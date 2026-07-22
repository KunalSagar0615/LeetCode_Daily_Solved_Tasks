var TimeLimitedCache = function() {
    this.map = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const exists =
        this.map.has(key) && this.map.get(key).expire > Date.now();

    this.map.set(key, {
        value: value,
        expire: Date.now() + duration
    });

    return exists;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    if (!this.map.has(key))
        return -1;

    const obj = this.map.get(key);

    if (obj.expire <= Date.now())
        return -1;

    return obj.value;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    let count = 0;

    for (const obj of this.map.values()) {
        if (obj.expire > Date.now())
            count++;
    }

    return count;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1); // 42
 * timeLimitedCache.count(); // 1
 */