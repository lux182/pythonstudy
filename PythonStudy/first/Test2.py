# -*- coding = utf-8 -*-
'''
Created on 2013��8��16��

@author: saico
'''
print("hello world")
print (2**5)

var = 1
print(var)

# x = int(input("x:"))
# y = int(input("y:"))
# print  (x*y)

def say_hello():
    print("hello")

say_hello()

print (int("1") + int("1"))
print (str(1) + "1")

print( ''''    段
            光
             伟''')
print (r'C:\log.txt')
print ('C:\\log.txt')
seq = "0123456789"
print (seq[0])
print (seq[-1])
print(seq[2:4])
print(seq[4:])

print( [1, 2, 3] + [4, 5, 6])

print( [1, 2, 3] * 3) 

print ([None] * 10) #生成一个空序列。

print( 1 in [1, 2, 3]) #成员判断。

print(1,2)

print ("% 10s" % "----")

print ({"title": "title", "body": "body"})

print (dict(title = "title", body = "body"))

print (dict([("title", "title"), ("body", "body")]))

dic = {"title": "title", "body": "body"};
print (dic["title"])
del dic["title"]
print (dic)

x, y, z = 1, 2, 3
print (x, y, z)
(x, y, z) = (1, 2, 3)
print (x, y, z)
(x, y, z) = [1, 2, 3]
print (x, y, z)

#下面的输入全部返回False。
print(bool(None))
print(bool(()))
print(bool([]))
print(bool({}))
print(bool(""))
print(bool(0))

#虽然这些值在条件运算中会当做False，但是本身不等于False。
print(True and "")
print(not "")
print(False == "")
print(False == 0) #0除外，bool类型的内部表示就是int类型。

print(0 < 1 < 10)
print(0 < 1 and 1 < 10)
print(not(0 > 1 > 10))
print(not(0 > 1 or 1 > 10))

if(10 > 1):
    print("10 > 1")
else:
    print("不可能发生")

print("10 > 1" if 10 > 1 else "不可能发生")

#== 和 is的差别，==比较的是内容，is比较的是引用。
x = [1, 2, 3]
y = x
z = [1, 2, 3]
print(x == y)
print(x == z)
print(x is y)
print(x is z)

#for循环类似C#的foreach，注意for后面是没有括号的，python真是能简洁就尽量简洁。
for x in range(1, 10):
    print(x)

for key in {"x":"xxx"}:
    print(key)

for key, value in {"x":"xxx"}.items():
    print(key, value)

for x, y, z in [["a", 1, "A"],["b", 2, "B"]]:
    print(x, y, z)

#带索引的遍历
for index, value in enumerate(range(0, 10)):
    print(index, value)

#好用的zip方法
for x, y in zip(range(1, 10), range(1, 10)):
    print(x, y)

#循环中的的else子句
from math import sqrt
for item in range(2, 99, 1):
    root = sqrt(item)
    if(root == int(root)):
        print(item)
        break
else:
    print("没有执行break语句。")

#pass、exec、eval
if(1 == 1):
    pass

exec('print(x)', {"x": "abc"})
print(eval('x*2', {"x": 5}))

def func_with_muti_return():
    return ("func_with_muti_return", "func_with_muti_return")
 
print(func_with_muti_return())

# 收集多余的位置参数
def func_with_collection_rest_parameters(x, y, *rest):
    print(x, y)
    print(rest)
func_with_collection_rest_parameters(1, 2, 3, 4, 5)

#命名参数
def func_with_named_parameters(x, y, z):
    print(x, y, z)
    
func_with_named_parameters(z = 1, y = 2, x = 3)

#默认值参数
def func_with_default_value_parameters(x, y, z = 3):
    print(x, y, z)

func_with_default_value_parameters(y = 2, x = 1)

#收集命名参数
def func_with_collection_rest_naned_parameters(*args, **named_agrs):
    print(args)
    print(named_agrs)

func_with_collection_rest_naned_parameters(1, 2, 3, x = 4, y = 5, z = 6)
