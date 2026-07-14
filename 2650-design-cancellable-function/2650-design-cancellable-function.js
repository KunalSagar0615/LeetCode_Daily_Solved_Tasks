/**
 * @param {Generator} generator
 * @return {[Function, Promise]}
 */
var cancellable = function(generator) {
    let cancelled = false;

    const cancel = () => {
        cancelled = true;
    };

    const promise = (async () => {
        let next;

        try {
            next = generator.next();

            while (!next.done) {
                try {
                    const value = await next.value;

                    if (cancelled) {
                        cancelled = false;
                        next = generator.throw("Cancelled");
                    } else {
                        next = generator.next(value);
                    }
                } catch (err) {
                    next = generator.throw(err);
                }
            }

            return next.value;
        } catch (err) {
            throw err;
        }
    })();

    return [cancel, promise];
};
/**
 * function* tasks() {
 *   const val = yield new Promise(resolve => resolve(2 + 2));
 *   yield new Promise(resolve => setTimeout(resolve, 100));
 *   return val + 1;
 * }
 * const [cancel, promise] = cancellable(tasks());
 * setTimeout(cancel, 50);
 * promise.catch(console.log); // logs "Cancelled" at t=50ms
 */