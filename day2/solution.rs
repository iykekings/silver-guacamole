fn parse_move(line: &str) -> (i32, i32) {
    line.split_once(" ")
        .map(|(dir, mag)| {
            let value = mag.parse::<i32>().unwrap();
            match dir {
                "forward" => (0, value),
                "down" => (value, 0),
                _ => (-value, 0),
            }
        })
        .unwrap()
}

pub fn solution() -> i32 {
    let (x, y) = std::fs::read_to_string("../input.txt")
        .unwrap()
        .lines()
        .fold((0, 0), |(acc1, acc2), line| {
            let (f, s) = parse_move(line);
            (acc1 + f, acc2 + s)
        });
    return x * y;
}
