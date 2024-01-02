def is_leap_year(year):
    """
    This function takes a single integer as input and returns True if the number is a leap year.

    For our purposes, leap years are:

        * Years divisible by 4 are leap years if not divisible by 100.
        * The exception to the above is if a year is divisible by 400.
        * No negative years are leap years.

    These rules mean years like 1900 are not leap years (divisible by 100),
    but 2000 is a leap year (divisible by 400).

    Inputs:
        year(int): A year to test

    Output:
        True if year is determined to be a leap year, False if not.
    """