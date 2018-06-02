(ns leiningen.new.options.devcards
  (:require [leiningen.new.options.helpers :as helpers]))

  (def option "+devcards")

(defn files [data]
  [["resources/public/cards.html" (helpers/render "resources/public/cards.html" data)]
   ["test/cards/my_cards.cljs" (helpers/render "test/cards/my_cards.cljs" data)]])
