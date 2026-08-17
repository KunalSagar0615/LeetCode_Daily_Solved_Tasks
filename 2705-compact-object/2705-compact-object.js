/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (obj === null || typeof obj !== 'object') {
        return obj;
    }

    if (Array.isArray(obj)) {
        return obj.filter(Boolean).map(compactObject);
    }

    const result = {};

    for (const key in obj) {
        if (obj[key]) {
            result[key] = compactObject(obj[key]);
        }
    }

    return result;
};