var myNum: number = 5;
var myString: string = "Hello Universe";
var myArr: number[] = [1,2,3,4];
var myObj: any = { name:'Bill'};

var anythingVariable: any = "Hey";
anythingVariable = 25; 

var arrayOne: Array<boolean> = [true, false, true, true]; 
var arrayTwo: Array<any> = [1, 'abc', true, 2];

myObj = { x: 5, y: 10 };

// object constructor
class MyNode {
	val: number;
	_priv: number = MyNode.prototype._priv;
    constructor(val: number) {
        this.val = 0;
        this.val = val;
    }
    doSomething () {
        this._priv = 10;
    }
};
let myNodeInstnace = new MyNode(1);

console.log(myNodeInstnace.val);

function myFunction(): void {
    console.log("Hello World");
    return;
}

function sendingErrors(): never {
	throw new Error('Error message');
}
