class SLL{
	private Node head;
	
	public SLL(){
		this.head = null;
	}
	
	public void add(int value){
		Node newNode = new Node(value);
		if(this.head == null){
			this.head = newNode;
		}
		else{
			Node pointer = this.head;
			while(pointer.getNext() != null){
				pointer = pointer.getNext();
			}
			pointer.setNext(newNode);
		}
	}
	
	public void remove(){
		Node pointer = this.head;
		if(pointer != null){
			if(pointer.getNext() == null){
				this.head = null;
			}
			else{
				while(pointer.getNext().getNext() != null){
					pointer = pointer.getNext();
				}
				pointer.setNext(null);
			}
		}
	}
	
	public void printValues(){
		if(this.head != null){
			System.out.println(this.head.getValue());
			Node pointer = this.head;
			while(pointer.getNext() != null){
				pointer = pointer.getNext();
				System.out.println(pointer.getValue());
			}
		}
	}
	
	public Node find(int value){
		if(this.head != null){
			Node pointer = this.head;
			if(pointer.getValue() == value){
				return (pointer);
			}
			while(pointer.getNext() != null){
				pointer = pointer.getNext();
				if(pointer.getValue() == value){
					return (pointer);
				}
			}
		}
		return (null);
	}
	
	public void removeAt(int nodes){
		if(this.head != null && nodes >= 0){
			Node pointer = this.head;
			if(nodes == 0){
				this.head = this.head.getNext();
			}
			Node previous = null;
			while(nodes != 0 && pointer.getNext() != null){
				previous = pointer;
				pointer = pointer.getNext();
				nodes--;
			}
			previous.setNext(pointer.getNext());
			pointer.setNext(null);
		}
		
	}
}