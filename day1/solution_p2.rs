fn main() {
    println!("{}", depth_increase_count());
}

fn depth_increase_count() -> usize {
    std::fs::read_to_string("./input")
        .unwrap()
        .lines()
        .map(|num| num.parse::<u16>().unwrap())
        .collect::<Vec<_>>()
        .windows(3)
        .map(|w| w.iter().sum::<u16>())
        .collect::<Vec<_>>()
        .windows(2)
        .filter(|&op| op[0] < op[1])
        .count()
}
