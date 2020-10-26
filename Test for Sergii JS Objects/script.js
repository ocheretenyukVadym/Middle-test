const firstObject = {
    firstKey: 1,
    objectKeyFirst: {
        string: 'hello',
        oddArray: [1, 3, 5],
        anotherObj: {
            key: 'Wat?'
        }
    },
    methodKey: function () {
        return this.objectKeyFirst.oddArray.length;
    }
}
const secondObject = {
    weirdArray: ['x'],
    objectKeyFirst: {
        oddArray: [5, 1, , 3]
    },
    methodKey: function () {
        return 3;
    }
}

delete secondObject.weirdArray;
delete secondObject.objectKeyFirst;
delete secondObject.methodKey;

secondObject.firstKey = firstObject.firstKey;
secondObject.objectKeyFirst = {...firstObject.objectKeyFirst,
                                oddArray: [...firstObject.objectKeyFirst.oddArray],
                                    anotherObj: { ...firstObject.objectKeyFirst.anotherObj } };

secondObject.methodKey = function () {
    return this.objectKeyFirst.oddArray.length;
}

console.log(isObjectsEqual(firstObject, secondObject));

function isObjectsEqual(obj1, obj2) {
    if (obj1 === obj2) return true;
    else {
        if (Object.keys(obj1).length != Object.keys(obj2).length) return false;
        for (let propName in obj1) {

            if (!obj2.hasOwnProperty(propName)) return false;
    
            if (obj1[propName].valueOf() !== obj2[propName].valueOf())
                if (!isObjectsEqual(obj1[propName], obj2[propName]))  return false;
        }
    }
    return true;
}




