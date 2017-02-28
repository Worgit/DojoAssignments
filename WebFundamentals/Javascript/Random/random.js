function lotto(quarters){
	for(var i = quarters; i > 0; i--){
		if(Math.floor(Math.random()*100) === 1){
			return (Math.floor(Math.random()*101)+50)+i;
		}
	}
	return 0;
}
console.log(lotto(100));