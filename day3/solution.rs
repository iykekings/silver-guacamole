use std::ops::Div;

fn folder(f: Vec<u32>, s: &&str) -> Vec<u32> {
    s.chars()
        .map(|c| c.to_digit(10).unwrap())
        .zip(f)
        .map(|(a, b)| a + b)
        .collect()
}

fn reverse(s: &str) -> String {
    s.chars()
        .map(|c| if c == '1' { '0' } else { '1' })
        .collect()
}

fn bin(s: &str) -> usize {
    usize::from_str_radix(&s, 2).unwrap()
}

fn mapper(s: u32, size: usize) -> String {
    if s as usize > size.div(2) {
        "1".to_string()
    } else {
        "0".to_string()
    }
}

pub fn solution(path: &str) -> usize {
    let file_res = std::fs::read_to_string(path).unwrap();
    let file = file_res.lines().collect::<Vec<_>>();
    let hl = file[0].len();
    let start: Vec<u32> = (0..hl).map(|_| 0).collect();

    let p = file
        .iter()
        .fold(start, folder)
        .iter()
        .map(|&s| mapper(s, file.len()))
        .collect::<String>();
    let g = reverse(&p);
    bin(&p) * bin(&g)
}

fn main() {
    println!("Test Answer is {}", solution("./test.txt"));
    println!("Answer is {}", solution("./input.txt"));
}
