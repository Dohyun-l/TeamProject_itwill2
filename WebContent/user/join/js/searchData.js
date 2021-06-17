const emailInput = document.querySelector("#email");
const nicknameInput = document.querySelector("#nickname");

const getPostRequest = (reqData) => {
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

const emailSearchHandler = async(event) => {
    const term = event.target.value;
    const URL = './SearchUserEmail.json';
    const state = await (await fetch(URL,getPostRequest(term))).json();
    console.log(state);
}

const nicknameSearchHandler = async(event) => {
    const term = event.target.value;
    const URL = './SearchUserNickname.json';
    const state = await (await fetch(URL,getPostRequest(term))).json();
    console.log(state);
}

emailInput.addEventListener("keyup",emailSearchHandler);
nicknameInput.addEventListener("keyup",nicknameSearchHandler);