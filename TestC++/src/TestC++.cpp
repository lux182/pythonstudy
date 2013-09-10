//============================================================================
// Name        : TestC++.cpp
// Author      : lxs
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	const int i = 1;
	const int *p = &i;

	const int a = 0;
	//这里的p就是指向const的指针。需要用const_cast来强制类型转换
	int *d = const_cast<int *> (&a);
	cout << d << endl;

	int sum = 0, value; //注意这里的sum要初始化,不然要报错.
	while (std::cin >> value) {
		sum += value;
	}
	std::cout << "sum is : " << sum << std::endl;
	return 0;
}
