# Dependencys

[Sonargraph](https://www.hello2morrow.com/products/sonargraph) shows the cycles between packages `bill <-> financial` and `bill <-> audit` (green half circle on the right) that are in this 'InitialVersion'.

![](images/sonargraph-folded.png)

Other dependencys are fine:
* `ui` is top package that uses/sees other (lower) package `bill`
* `bill.data` is inner package of `bill` that is only used by outer package `bill`

Here we see who uses `data` package:

![](images/sonargraph-expanded-data-selected.png)

Here we see that the cycles between `bill <-> financial` and `bill <-> audit` are caused by class `Bill.java` in `bill`.

![](images/sonargraph-expanded.png)