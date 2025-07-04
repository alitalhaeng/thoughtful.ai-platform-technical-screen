# Package Sorter

This project implements a sorting function for packages in a robotic automation system. Based on the dimensions and mass of each package, it determines whether the package should be classified as:

- `STANDARD`: Neither bulky nor heavy
- `SPECIAL`: Either bulky or heavy
- `REJECTED`: Both bulky and heavy

---

## Problem Description

A package is classified as:

- **Bulky** if:
  - Its volume (Width × Height × Length) is **≥ 1,000,000 cm³**, **OR**
  - Any one of its dimensions is **≥ 150 cm**.
  
- **Heavy** if its mass is **≥ 20 kg**.

### Dispatch Categories:
| Bulky | Heavy | Category |
|------|-------|----------|
| No   | No    | STANDARD |
| Yes  | No    | SPECIAL  |
| No   | Yes   | SPECIAL  |
| Yes  | Yes   | REJECTED |

---

## Function Signature

```java
public static String sort(int width, int height, int length, int mass)
