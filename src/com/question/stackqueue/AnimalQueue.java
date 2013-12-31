/* 
 * Cracking the coding interview (5th edition)
 * Chapter 3 - Stacks and Queues
 * 
 * Question 3.7
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in,
 * first out" basis. People must adopt either the "oldest" (based on arrival time) of
 * all animals at the shelter, or they can select whether they would prefer a dog or
 * a cat (and will receive the oldest animal of that type). They cannot select which
 * specific animal they would like. Create the data structure to maintain this system
 * and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
 * You may use the built-in LinkedList data structure.
 * 
 * Solution - pg 217
 * 
 */
package com.question.stackqueue;

import java.util.Iterator;
import java.util.LinkedList;

public class AnimalQueue {
	private static final Integer DOG = 1;
	private static final Integer CAT = 2;
	
	private LinkedList<Animal> animals;

	public AnimalQueue() {
		animals = new LinkedList<Animal>();
	}
	public void enqueue(Animal item) {
		animals.add(item);
	}

	public Animal dequeue() {
		return animals.poll();
	}

	public Animal peekFront() {
		return animals.peek();
	}
	
	public Animal dequeueCat() {
		if (animals.peek().getType() == CAT) {
			return animals.poll();
		}
		Iterator<Animal> iter = animals.iterator();
		while (iter.hasNext()) {
			Animal ani = iter.next();
			if (ani.getType() != DOG) {
				animals.remove(ani);
				return ani;
			}
		}
		return null;
		
	}
	
	public Animal dequeueDog() {
		if (animals.peek().getType() == DOG) {
			return animals.poll();
		}
		Iterator<Animal> iter = animals.iterator();
		while (iter.hasNext()) {
			Animal ani = iter.next();
			if (ani.getType() != CAT) {
				animals.remove(ani);
				return ani;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		return animals.isEmpty();
	}
	
	@Override
	public String toString() {
		return animals.toString();
	}
	
	private static class Animal {
		private Integer type;

		public Animal(Integer type) {
			this.setType(type);
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			return "Animal" + type;
		}
		
	}

	public static void main(String[] args) {
		AnimalQueue queue = new AnimalQueue();
		queue.enqueue(new Animal(DOG));
		queue.enqueue(new Animal(DOG));
		queue.enqueue(new Animal(CAT));
		queue.enqueue(new Animal(DOG));
		queue.enqueue(new Animal(CAT));
		queue.enqueue(new Animal(CAT));
		queue.enqueue(new Animal(CAT));
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
		queue.dequeueCat();
		System.out.println(queue);
		queue.dequeueDog();
		System.out.println(queue);
		queue.dequeueDog();
		System.out.println(queue);
		System.out.println(queue);
	}

}
