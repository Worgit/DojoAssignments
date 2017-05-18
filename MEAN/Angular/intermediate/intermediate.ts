	// 1
	interface UserInterface {
		// ...
		name: string
		email: string
		phoneNumber?: number
		created_at: Date;
	}
	
	// 2
	
	function userPrint(user): void{
		console.log(user.name);
		console.log(user.email);
		console.log(user.phoneNumber);
		console.log(user.created_at);
		// ...
	}
