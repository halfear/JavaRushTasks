package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private int size;

    public CustomTree() {
        this.root = new Entry<>("10");
        this.size = 1;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        super.add(index, element);
    }

    @Override
    public boolean add(String s) {
        Entry<String> newElement = new Entry<>(s);
        Entry<String> currentElement = root;

        while (true) {
            if (s.equals(currentElement.elementName)) {
                return false;
            } else if (s.compareTo(currentElement.elementName) < 0) {
                if (currentElement.availableToAddLeftChildren) {
                    currentElement.leftChild = newElement;
                    currentElement.leftChild.parent = currentElement;
                    size++;
                    return true;
                } else currentElement = currentElement.leftChild;
            } else if (s.compareTo(currentElement.elementName) > 0) {
                if (currentElement.availableToAddRightChildren) {
                    currentElement.rightChild = newElement;
                    currentElement.rightChild.parent = currentElement;
                    size++;
                    return true;
                }
            }
        }
    }

    public Entry<String> findElement(String s) {
        Entry<String> currentElement = root;

        while (!currentElement.elementName.equals(s)) {
            if (s.compareTo(currentElement.elementName) < 0) {
                if (currentElement.availableToAddLeftChildren) return null;
                else currentElement = currentElement.leftChild;
            } else if (s.compareTo(currentElement.elementName) > 0) {
                if (currentElement.availableToAddRightChildren) return null;
                else currentElement = currentElement.rightChild;
            }
        }
        return currentElement;
    }

    public String getParent(String s) {
        return findElement(s) != null ? findElement(s).parent.elementName : "Нет такого элемента";
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
