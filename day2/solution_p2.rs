fn add(value: Option<i32>) -> Box<dyn Fn(i32, i32) -> i32> {
    value.map_or(Box::new(|a, _| (a)), |v| Box::new(move |a, b| (b * v + a)))
}

fn parse_move(line: &str) -> (Box<dyn Fn(i32, i32) -> i32>, i32, i32) {
    line.split_once(" ")
        .map(|(dir, mag)| {
            let value = mag.parse::<i32>().unwrap();
            match dir {
                "forward" => (add(Some(value)), 0, value),
                "down" => (add(None), value, 0),
                _ => (add(None), -value, 0i32),
            }
        })
        .unwrap()
}

pub fn solution() -> i32 {
    let (x, _, y) = std::fs::read_to_string("../input.txt")
        .unwrap()
        .lines()
        .map(|it| parse_move(it))
        .fold((0, 0, 0), |(a, b, c), (f, x, y)| (f(a, b), b + x, c + y));
    return x * y;
}
