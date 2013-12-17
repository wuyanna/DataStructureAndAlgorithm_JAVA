/* 
 * Cracking the coding interview (5th edition)
 * Chapter 3 - Stacks and Queues
 * 
 * Question 3.4
 * In the classic problem of the Tower of Hanoi, you have 3 towers 
 * and N disks of different sizes which can slide onto any tower.
 * The puzzles starts with disks sorted in ascending order of size 
 * from top to bottom (i.e., each disk sits on top of an even larger 
 * one). You have the following constraints:
 * (1) only one disk can be moved at a time.
 * (2) a disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 * 
 * Solution - pg 211
 * 
 */
package com.question.stackqueue;

import com.ds.stack.ArrayStack;
import com.ds.stack.IStack;

public class HanoiTower {
	
	private static final Integer SOURCE_TOWER = 0;
	private static final Integer MIDDLE_TOWER = 1;
	private static final Integer DEST_TOWER = 2;
	
	private IStack<Integer>[] stacks;
	private Integer numOfDisks;
	
	public HanoiTower(Integer numOfDisks) {
		stacks = new ArrayStack[3];
		stacks[0] = new ArrayStack<Integer>();
		stacks[1] = new ArrayStack<Integer>();
		stacks[2] = new ArrayStack<Integer>();
		this.numOfDisks = numOfDisks;
		for (Integer i = numOfDisks; i > 0; i--) {
			stacks[0].push(i);
		}
	}
	
	public void hanoiMove() {
		moveTower(numOfDisks,SOURCE_TOWER,DEST_TOWER,MIDDLE_TOWER);
	}
	public void moveTower(Integer num, Integer src, Integer dest, Integer mid) {
		if (num > 0) {
			moveTower(num-1, src, mid, dest);
			move(src, dest);
			moveTower(num-1, mid, dest, src);
		}
	}
	
	public void move(Integer src, Integer dest) {
		IStack<Integer> stackSrc = stacks[src];
		IStack<Integer> stackDest = stacks[dest];
		Integer data = stackSrc.pop();
		stackDest.push(data);
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			buf.append("stack " + i + ": [" + stacks[i].toString() + "] ");
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		HanoiTower hanoi = new HanoiTower(6);
		System.out.println(hanoi);
		hanoi.hanoiMove();
		System.out.println(hanoi);
	}

}
