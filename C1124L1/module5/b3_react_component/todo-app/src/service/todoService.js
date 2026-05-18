const todoList = [
    {
        id: 1,
        name: "Learn React"
    },
    {
        id: 2,
        name: "Build a todo app"
    },
    {
        id: 3,
        name: "Deploy the app"
    }
];

export function getAll(){
    // call API
    return [...todoList]
}

// export function deleteById(id){
//     for (let i = 0; i <studentList.length ; i++) {
//         if (studentList[i].id==id){
//             studentList.splice(i,1);
//             break
//         }
//     }
// }

export function add(name){
    const newTodo = {
        id: Date.now(),
        name: name
    }
    todoList.push(newTodo)
    return newTodo
}