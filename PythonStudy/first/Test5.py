# coding=utf-8

__metaclass__ = type

# 类型定义
# 实例方法必的第一个参数代表类型实例，类似其他语言的this。
class Animal:
    name = "未知" # 属性定义。

    def __init__(self, name): #构造方法定义。
        self.name = name

    def getName(self): # 实例方法定义。
        return self.name

    def setName(self, value):
        self.name = value

print(Animal.name) # 未知
print(Animal.__dict__["name"]) # 未知

animal = Animal("狗狗")
print(animal.name) # 狗狗
print(animal.__dict__["name"]) # 狗狗
print(Animal.name) # 未知
print(Animal.__dict__["name"]) # 未知
print(animal.__class__.name) # 未知
print(animal.__class__.__dict__["name"]) # 未知