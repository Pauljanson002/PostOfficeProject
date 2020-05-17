document.querySelector("#type").addEventListener("change",()=>{
    let text =  document.querySelector("span").innerText;
    let newValue = parseInt(text)+1;
    document.querySelector("span").innerText = newValue;
})
