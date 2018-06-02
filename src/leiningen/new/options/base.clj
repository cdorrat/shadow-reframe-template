(ns leiningen.new.options.base
  (:require [leiningen.new.options.helpers :as helpers]))

(defn files [data]
  [["README.md" (helpers/render "README.md" data)]
   ["shadow-cljs.edn" (helpers/render "shadow-cljs.edn" data)]
   ["package.json" (helpers/render "package.json" data)]
   [".gitignore" (helpers/render ".gitignore" data)]
   ["resources/public/index.html" (helpers/render "resources/public/index.html" data)]
   ["src/{{sanitized}}/config.cljs" (helpers/render "src/config.cljs" data)]
   ["src/{{sanitized}}/core.cljs" (helpers/render "src/core.cljs" data)]
   ["src/{{sanitized}}/db.cljs" (helpers/render "src/db.cljs" data)]
   ["src/{{sanitized}}/events.cljs" (helpers/render "src/events.cljs" data)]
   ["src/{{sanitized}}/routes.cljs" (helpers/render "src/routes.cljs" data)]
   ["src/{{sanitized}}/subs.cljs" (helpers/render "src/subs.cljs" data)]
   ["src/{{sanitized}}/views.cljs" (helpers/render "src/views.cljs" data)]
   ])
