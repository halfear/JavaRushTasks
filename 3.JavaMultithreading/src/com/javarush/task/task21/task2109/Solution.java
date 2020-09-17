package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException {
            String nameCopy = this.getName();

            return new C(this.getI(), this.getJ(), nameCopy);
        }

        @Override
        public int hashCode() {
            int result = this.getI();
            result = 31 * result + getJ();
            result = 31 * result + (getName() != null ? getName().hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(obj == null) return false;
            if(!(obj instanceof C)) return false;

            C c = (C) obj;
            return c.getI() == this.getI() && c.getJ() == this.getJ() && c.getName().equals(this.getName());
        }
    }

    public static void main(String[] args) {

    }
}
