

function goSearchUser(searchWord)
{
	var search = location.search
	 
	var params = new URLSearchParams(search);
	 
	var searchWord= params.get('searchWord');
	
	
	alert(searchWord)
	 
	location.href = 'Search.user?searchWord=' + searchWord;
}





function goSearchPost(searchWord)
{
	var search = location.search
	 
	var params = new URLSearchParams(search);
	 
	var searchWord= params.get('searchWord');
	
	
	alert(searchWord)
	location.href = 'Search.post?searchWord=' + searchWord;
}


/*
function goSearchUser()
{
	var searchWord = urlParams.get('q')
	location.href = 'Search.user?searchWord='+ searchWord;
}

function goSearchPost()
{
	var searchWord = urlParams.get('q')
	location.href = 'Search.post?searchWord='+ searchWord;
}*/