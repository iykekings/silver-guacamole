# Adventure of code in Rust, Haskell, Kotlin, F# and Clojure

Since I haven't used some of these languages before now, I will be very slow with pushing new solutions.
Do feel free to contribute in any way!

## Requirements

- Rustc - <https://rustup.rs/#>
- Kotlinc - <https://kotlinlang.org/docs/command-line.html#manual-install>
- Clojure - <https://clojure.org/guides/getting_started>
- GHC - <https://www.haskell.org/ghc/>
- .Net Core SDK for F# - <https://fsharp.org/>

## Running

cd to the directory of the day you want, like `cd day1`

### Rust

```sh
rustc {filename}.rs  && ./{filename} && rm {filename}
```

where filename is like `solution`

### Kotlinc

```sh
kotlinc -script {filename}.kts
```

### Haskell

- ```sh
    ghci {filename}.hs
    ```

### F Sharp

```sh
dotnet fsi {filename}.fsx
```

### Clojure

```sh
clj -M {filename}.clj
```
