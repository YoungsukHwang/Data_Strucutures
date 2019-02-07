public class Interact {

	myLinkedList myl;

	public Interact() {
		myl = new myLinkedList();
	}

	public void addString() { // A
	}

	public void checkIfEmpty() { // C
		if (myl.isEmpty())
			System.out.print("The list is empty.\n ");
		else
			System.out.print("The list contains some element(s).\n");
	}

	public void searchForString() { // E
	}

	public void listStrings() { // L
		System.out.println(myl.toString());
	}

	public void listCurrentSize() { // O
		System.out.println("The current size is " + myl.size());
	}

	public void quit() { // Q
	}

	public void removeString() { // R
		// System.out.println("str was removed");
	}

	public void reverse() { // T
		myLinkedList reversedMyl = new myLinkedList();
		int size = myl.size;
		for (int i = 0; i < size; i++) {
			reversedMyl.add(0, myl.remove(0));
		}
		myl = reversedMyl;
		System.out.println("list reversed");
	}

	public void removeDuplicates() { // U
		int rmvcnt = 0;
		myl.resetIter();
		Node dupli_iter = myl.iter;

		while (dupli_iter != null) {
			Node iter2 = dupli_iter.next;

			while (iter2 != null) {

				if (dupli_iter.str.equals(iter2.str)) {
					Node cont = iter2.next;
					Object obj = myl.remove(myl.indexOf(iter2));
					rmvcnt++;
					iter2 = cont;
				} else {
					iter2 = iter2.next;
				}
			}

			dupli_iter = dupli_iter.next;
		}

		if (rmvcnt == 0)
			System.out.println("there is no duplicate");
		else
			System.out.println("duplicate removed");
	}

	public void menu() { // ?
		System.out.println("Choice\t\tAction");
		System.out.println("------\t\t------");
		System.out.println("A\t Add String");
		System.out.println("C\t Check if Empty");
		System.out.println("E\t Search for String");
		System.out.println("L\t List Strings");
		System.out.println("O\t List Current Size");
		System.out.println("Q\t Quit");
		System.out.println("R\t Remove String");
		System.out.println("T\t Reverse");
		System.out.println("U\t Remove Duplicate");
		System.out.println("?\t Display Help");
	}
}
