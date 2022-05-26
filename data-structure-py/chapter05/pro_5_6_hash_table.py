#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_5_6_hash_table.py
# @Time      : 2022/5/26 14:50
# @Author    : liang.lian

class HashTable:
    def __init__(self):
        self.size = 11
        self.slots = [None] * self.size
        self.data = [None] * self.size

    def put(self, key, data):
        hash_value = self.hash(key, self.size)
        if self.slots[hash_value] == None:
            self.slots[hash_value] = key
            self.data[hash_value] = data
        else:
            if self.slots[hash_value] == key:
                self.data[hash_value] = data
            else:
                next_slot = self.rehash(hash_value, self.size)
                while self.slots[next_slot] != None and self.slots[next_slot] != key:
                    next_slot = self.rehash(next_slot, self.size)
                if self.slots[next_slot] == None:
                    self.slots[next_slot] = key
                    self.data[next_slot] = data
                else:
                    self.data[next_slot] = data

    @staticmethod
    def hash(key, size):
        return key % size

    @staticmethod
    def rehash(old_hash, size):
        return (old_hash + 1) % size

    def get(self, key):
        start_slot = self.hash(key, self.size)
        
        data = None
        stop = False
        found = False
        
        position = start_slot
        while self.slots[position] != None and not found and not stop:
            if self.slots[position] == key:
                found = True
                data = self.data[position]
            else:
                position = self.rehash(position, self.size)
                if position == start_slot:
                    stop = True
        return data
    
    def __getitem__(self, key):
        return self.get(key)
    
    def __setitem__(self, key, value):
        self.put(key, value)
    

table = HashTable()
table[54] = "cat"
table[26] = "dog"
table[93] = "lion"
table[17] = "tiger"
table[77] = "bird"
table[31] = "cow"
table[44] = "goat"
table[55] = "pig"
table[20] = "chicken"

print(table.slots)
print(table.data)

print(table[20])
print(table[17])

table[20] = "duck"
print(table[20])

print(table.data)
print(table[99])
