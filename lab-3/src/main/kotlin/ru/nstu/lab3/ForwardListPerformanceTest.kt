package ru.nstu.lab3

import ru.nstu.lab3.factory.ObjectFactoryRegistry
import ru.nstu.lab3.model.ForwardList
import java.util.*
import kotlin.Comparator

class ListPerformanceTest {
    companion object {
        @JvmStatic
        fun test(count: Int) {
            var list: ForwardList<Int> = getFilledList(count)
            val intComparator: Comparator<Int> = Comparator() { a, b ->
                when {
                    (a == b) -> 0
                    (a < b) -> -1
                    else -> 1
                }
            }
            val startSortTime = System.nanoTime()
            list = list.mergeSort(intComparator)
            val stopSortTime = System.nanoTime() - startSortTime

            println("Время сортировки " + count + " случайных элементов типа INTEGER: " + stopSortTime / 1000000 + " мс")
        }

        @JvmStatic
        fun getFilledList(count: Int): ForwardList<Int> {
            var list: ForwardList<Int> = ForwardList();
            while (list.size < count) {
                list.add((java.lang.Math.random() * 100).toInt())
            }
            return list
        }
    }
}