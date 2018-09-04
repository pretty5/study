function change(path) {
    document.getElementById("image").src=path
}
function radioClick() {
    //var radioArr=document.getElementsByName("sex");
    var radioArr=$("input[name='sex']");
    for (var i in radioArr){
        if (radioArr[i].checked){
            alert(radioArr[i].name+" "+radioArr[i].value)
            break
        }

    }

}
function checkboxClick(){
    var checkboxArray = document.getElementsByName("names");
    var str = "";
    for(var cnt in checkboxArray){
        if(checkboxArray[cnt].checked){
            str = str + checkboxArray[cnt].value;
        }
    }
    alert("当前选中的值为："+str);
}
function checkPassword() {
    var value=document.getElementById("password").value
    if (value.length<6){
        alert('password is too short,at least 6 chars')
    }
}
