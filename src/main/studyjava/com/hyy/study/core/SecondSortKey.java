package com.hyy.study.core;

import java.io.Serializable;

import scala.math.Ordered;

public class SecondSortKey implements Serializable, Ordered<SecondSortKey>{

	private static final long serialVersionUID = 5431844887224611430L;

	private int first;
	private int second;
	
	@Override
	public String toString() {
		return "SecondSortKey [first=" + first + ", second=" + second + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecondSortKey other = (SecondSortKey) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
		return true;
	}

	public SecondSortKey(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public boolean $greater(SecondSortKey that) {
		if(this.first > that.getFirst()){
			return true;
		}else if(this.first == that.getFirst() && this.second > that.getSecond()){
			return true;
		}
		return false;
	}

	@Override
	public boolean $greater$eq(SecondSortKey that) {
		if(this.$greater(that)){
			return true;
		}else if(this.first == that.getFirst() && this.second == that.getSecond()){
			return true;
		}
		return false;
	}

	@Override
	public boolean $less(SecondSortKey that) {
		if(this.first < that.getFirst()){
			return true;
		}else if(this.first == that.getFirst() && this.second < that.getSecond()){
			return true;
		}
		return false;
	}

	@Override
	public boolean $less$eq(SecondSortKey that) {
		if(this.$less(that)){
			return true;
		}else if(this.first == that.getFirst() && this.second == that.getSecond()){
			return true;
		}
		return false;
	}

	@Override
	public int compare(SecondSortKey that) {
		if(this.first - that.getFirst() != 0){
			return this.first - that.getFirst();
		}else{
			return this.second - that.getSecond();
		}
	}

	@Override
	public int compareTo(SecondSortKey that) {
		if(this.first - that.getFirst() != 0){
			return this.first - that.getFirst();
		}else{
			return this.second - that.getSecond();
		}
	}

}
