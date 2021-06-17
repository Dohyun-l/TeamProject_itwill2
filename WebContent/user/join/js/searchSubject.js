import {getPostRequest} from "./searchData.js"
const majorInput = document.querySelector("#major");
const interInput = document.querySelector("#inter");

const searchSubject = async(event) => {
    const $target = event.target;
    const $term = $target.value;
    const URL = "SearchSubject.json";
    const data = await (await fetch(URL,getPostRequest($term))).json();
    console.log(data);
}

majorInput.addEventListener("keyup",searchSubject)
interInput.addEventListener("keyup",searchSubject)