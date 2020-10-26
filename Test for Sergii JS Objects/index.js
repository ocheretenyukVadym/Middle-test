// і завдання від Сергія на тест:
// Є два обєкти : зробіть так, щоб щоб secondObject === firstObject, не змінюючи firstObject. Також напишіть ф-цію, яка порівняє ці об"єкти (isSameObjects(obj1, obj2)) і поверне true/false;
// 5:25

// function isObjectsEqual(obj1, obj2) {
//     return obj1.x === obj2x;
// }
// isObjectsEqual(o1, o2) // return false
// o2.x = 1;
// isObjectsEqual(o1, o2) // return true


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

function isObjectsEqual(obj1, obj2) {
        
if(obj1 === obj2){
    return true;
}
else{
    if(Object.keys(obj1).length != Object.keys(obj2).length){ // Проверка на одинаковое количество свойств
        return false;
    }
    for(let propName in obj1){

        if (! obj2.hasOwnProperty(propName)) { // Есть ли свойства в обоих объектах
            return false;
        }
        if(obj1[propName].valueOf() !== obj2[propName].valueOf()){ // Одинаковы ли значения свойст 
            if(! deepEqual(obj1[propName], obj2[propName]) ){ // проверка объекта в объекте
                return false;
            }

       }
    }
} 
return true; 
    }

console.log(isObjectsEqual(firstObject, secondObject));

