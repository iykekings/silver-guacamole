use std::{fs::read_to_string, num::ParseIntError};

fn main() -> Result<(), ParseIntError> {
    read_input().map(|inp| println!("Result is {}", depth_increase_count(&inp)))
}

fn read_input() -> Result<Vec<u16>, ParseIntError> {
    read_to_string("./input")
        .expect("couldn't read file")
        .lines()
        .map(|num| num.parse::<u16>())
        .collect::<Result<Vec<_>, ParseIntError>>()
}

fn depth_increase_count(input: &[u16]) -> u16 {
    input
        .windows(2)
        .fold(0, |acc, e| if e[0] < e[01] { acc + 1 } else { acc })
}
