#-*-coding=UTF-8 -*-
'''
Created on 2013年8月16日

@author: saico
'''
# python支持闭包
def func(x):
    def inner_func(y):
        print(x + y)

    return inner_func

inner_func = func(10)
inner_func(1)
inner_func(2)

#函数作为对象
def func2(fn, arg):
    fn(arg)

func2(print, "hello")
func2(lambda arg : print(arg), "hello")