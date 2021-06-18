import {getPostRequest} from "./searchData.js"
const majorInput = document.querySelector("#major");
const interInput = document.querySelector("#inter");
const cofirmContainer = document.querySelector(".cofirmContainer");
const InputContainer = document.querySelector(".InputContainer");
const searchBox1 = document.querySelector("#searchBox1");

const searchSubject = async(event) => {
    const $target = event.target;
    const $term = $target.value;

    const URL = "SearchSubject.json";
    const data = await (await fetch(URL,getPostRequest($term))).json();
    console.log(data);

    searchBox1.innerHTML = data.map(item => {
        return `<div><a class="e" href="#">${item.subName}</a></div>`
    }).join('');
}

majorInput.addEventListener("keyup",searchSubject)
interInput.addEventListener("keyup",searchSubject)