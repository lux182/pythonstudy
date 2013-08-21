# coding=utf-8

# 只有函数执行才会开启一个作用域。
if(2 > 1):
    x = 1

print(x) # 会输出1。


# 使用vars()函数可以访问当前作用域包含的变量。
x = 1
print(vars()["x"])

# 使用globals()函数可以访问全局作用域。
x = 1

def func():
    print(globals()["x"])

func()

# 使用locals()函数可以访问局部作用域。
def func1():
    x = 2
    print(locals()["x"])

func1()

# 每个函数定义时都会记住所在的作用域。
# 函数执行的时候会开启一个新的作用域，函数内变量访问的规则是：先访问当前作用域，如果没有就访问函数定义时的作用域，递归直到全局作用域。
x = 1

def func2():
    y = 2
    print(x, y) # 输出1 2

func2()


# 变量赋值始终访问的是当前作用域。
x = 1

def func3():
    x = 2
    y = 2
    print(x, y) # 输出2 2

func3()
print(x) #输出 1

# 局部变量会覆盖隐藏全局变量，想访问全局变量可以采用global关键字或globals()函数。
x = 1

def func4():
    global x
    x = 2
    y = 2
    print(x, y) # 输出2 2

func4()
print(x) #输出 2