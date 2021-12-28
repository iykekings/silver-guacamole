fn select_next(chars: Vec<char>, check: fn(usize, f32) -> bool) -> char {
    let count = chars.iter().filter(|&&c| c == '1').count();
    check(count, chars.len() as f32 / 2.0)
        .then(|| '1')
        .unwrap_or('0')
}

pub fn fold_rec(ss: Vec<&str>, check: fn(usize, f32) -> bool) -> &str {
    fold_rec_p(ss, 0, check)[0]
}

fn bin(s: &str) -> usize {
    usize::from_str_radix(&s, 2).unwrap()
}

fn fold_rec_p(xs: Vec<&str>, i: usize, check: fn(usize, f32) -> bool) -> Vec<&str> {
    match xs.as_slice() {
        &[_] => xs,
        _ => {
            let sel = select_next(
                xs.iter().map(|&x| x.chars().nth(i).unwrap()).collect(),
                check,
            );
            let selected: Vec<&str> = xs
                .into_iter()
                .filter(|&f| f.chars().nth(i).map_or(false, |c| c == sel))
                .collect();
            fold_rec_p(selected, i + 1, check)
        }
    }
}

pub fn solution(path: &str) -> usize {
    let file_res = std::fs::read_to_string(path).unwrap();
    let file = file_res.lines().collect::<Vec<_>>();
    let m = fold_rec(file.clone(), |u, f| u as f32 >= f);
    let n = fold_rec(file, |u, f| (u as f32) < f);
    bin(m) * bin(n)
}

fn main() {
    println!("Test Answer is {}", solution("./test.txt"));
    println!("Answer is {}", solution("./input.txt"));
}
