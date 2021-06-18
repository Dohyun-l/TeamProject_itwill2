const emailInput = document.querySelector("#email");
const nicknameInput = document.querySelector("#nickname");
const joinForm = document.querySelector("#joinForm");

export const getPostRequest = (reqData) => {
    let data = {
        reqData:reqData
	}
	
	let fetchData = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    return fetchData;
}

const SearchData = async(event,url) => {
    const $target = event.target;
    const $term = $target.value;
    const URL = url;
    const state = await (await fetch(URL,getPostRequest($term))).json();
    
    if(state.exists){
        $target.style.borderColor = 'red';
        $target.classList.remove("permit")
    } else {
        $target.style.borderColor = 'green';
        $target.classList.add("permit");
    }
}

const emailSearchHandler = async(event) => {
    const URL = './SearchUserEmail.json';
    await SearchData(event, URL);
}

const nicknameSearchHandler = async(event) => {
    const URL = './SearchUserNickname.json';
    await SearchData(event, URL);
}

const checkAuthHandler = async(event) => {
    if(!emailInput.classList.contains("permit") || !nicknameInput.classList.contains("permit")){
        event.preventDefault()
    } 
}

emailInput.addEventListener("keyup",emailSearchHandler);
nicknameInput.addEventListener("keyup",nicknameSearchHandler);
joinForm.addEventListener("submit", checkAuthHandler);

