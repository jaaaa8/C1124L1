const studentList = [
    {
        id: 1,
        name:"chánh",
        age: 20,
        address: "hà nội"
    },
    {
        id: 2,
        name:"hải heo",
        age: 21,
        address: "đà nẵng"
    },
    {
        id: 3,
        name:"trung già",
        age: 22,
        address: "hồ chí minh"
    }
]

export function getAll(){
    // call API
    return [...studentList]
}

// export function deleteById(id){
//     for (let i = 0; i <studentList.length ; i++) {
//         if (studentList[i].id==id){
//             studentList.splice(i,1);
//             break
//         }
//     }
// }