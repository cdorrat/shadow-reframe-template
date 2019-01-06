# food-client

A [re-frame](https://github.com/Day8/re-frame) application designed to ... well, that part is up to you.

## Development Mode

### Before the first run 
  - run ```npm install``` 
  - run ```npm run less```
  
### Building with shadow-cljs
  - run ```npm install``` 
  - run ```npm run watch```

work out how to get emacs repl connected...

### Start Cider from Emacs:

Put this in your Emacs config file: (only required until clojure-mode is updated)

```
(custom-set-variables
 '(clojure-build-tool-files
   (quote
    ("project.clj" "build.boot" "build.gradle" "shadow-cljs.edn"))))
```

Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`)

Workaround for a bug in cider-0.18:

When the clojure script repl opens & a browser has connected select the clojurescript buffer, press `C-:` and enter ```(cider-repl-set-type "cljs")```


### Release application:

```shadow-cljs release browser```

