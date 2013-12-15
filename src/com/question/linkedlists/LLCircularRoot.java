/* 
 * Cracking the coding interview (5th edition)
 * Chapter 2 - Linked Lists
 * 
 * Question 2.6
 * Given a circular linked list, implement an algorithm 
 * which returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list 
 * in which a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 * 
 * Solution - pg 193
 * 
 */
package com.question.linkedlists;

import java.util.Hashtable;

import com.ds.linkedlist.SinglyLinkedListNode;

public class LLCircularRoot {

	// cannot use hashtable. because hashcode of circular linked list will not terminate
	public SinglyLinkedListNode<Integer> findCircularRoot(
			SinglyLinkedListNode<Integer> node) {
		Hashtable<SinglyLinkedListNode<Integer>,Boolean> table = 
				new Hashtable<SinglyLinkedListNode<Integer>,Boolean>();
		SinglyLinkedListNode<Integer> temp = node;
		while (temp != null) {
			if (table.containsKey(temp)) {	// if node has already appeared
				return temp;
			}
			table.put(temp, true);
			temp = temp.getNext();
		}
		return temp;
	}
	
	public static void main(String[] args) {
		SinglyLinkedListNode<Integer> nodeE = new SinglyLinkedListNode<Integer>(null, 5);
		SinglyLinkedListNode<Integer> nodeD = new SinglyLinkedListNode<Integer>(nodeE, 4);
		SinglyLinkedListNode<Integer> nodeC = new SinglyLinkedListNode<Integer>(nodeD, 3);
		SinglyLinkedListNode<Integer> nodeB = new SinglyLinkedListNode<Integer>(nodeC, 2);
		SinglyLinkedListNode<Integer> nodeA = new SinglyLinkedListNode<Integer>(nodeB, 1);
		nodeE.setNext(nodeC);
		
		LLCircularRoot cir = new LLCircularRoot();
		System.out.println(cir.findCircularRoot(nodeA).getData());

	}

}
