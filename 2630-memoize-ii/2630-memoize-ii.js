/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map();

    return function (...args) {
        let curr = cache;

        for (const arg of args) {
            if (!curr.has(arg)) {
                curr.set(arg, new Map());
            }
            curr = curr.get(arg);
        }

        if (curr.has("result")) {
            return curr.get("result");
        }

        const result = fn(...args);
        curr.set("result", result);

        return result;
    };
}