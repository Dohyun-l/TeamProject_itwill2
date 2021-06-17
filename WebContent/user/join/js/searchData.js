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

const SearchData = async(event,url) => {
    const $target = event.target;
    const $term = $target.value;
    const URL = url;
    const state = await (await fetch(URL,getPostRequest($term))).json();
    
    if(state.exists){
        $target.style.borderColor = 'red';
    } else {
        $target.style.borderColor = 'green';
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

emailInput.addEventListener("keyup",emailSearchHandler);
nicknameInput.addEventListener("keyup",nicknameSearchHandler);