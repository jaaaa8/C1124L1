const studentList = [
    {
        id: 1,
        name:"chánh"
    },
    {
        id: 2,
        name:"hải heo"
    },
    {
        id: 3,
        name:"trung già"
    }
]

export function getAll(){
    // call API
    return [...studentList]
}

export function deleteById(id){
    for (let i = 0; i <studentList.length ; i++) {
        if (studentList[i].id==id){
            studentList.splice(i,1);
            break
        }
    }
}

export function createStudent(student){
    studentList.push(student);
}