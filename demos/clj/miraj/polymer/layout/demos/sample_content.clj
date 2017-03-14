(ns miraj.polymer.layout.demos.sample-content
  (:require [clojure.java.io :as io]
            [clojure.pprint :as pp]
            [miraj.core :as miraj]
            [miraj.html :as h]
            [miraj.polymer.protocol :as poly]
            [miraj.html.protocol :as hp]
            [miraj.polymer.paper :as paper]

            ;; for testing only:
            [miraj.compiler :as wc]
            [miraj.co-dom :as codom]))


(miraj/defcomponent data :html sample-data
  "Sample data component"

  ;;(:require [miraj.polymer.paper :as paper])

  (:cljs (println "HELLO"))

  {:polymer/properties

   {:size {:type Number
           :value 0
           :observer (fn [new old] (println "OBSERVED SIZE"))}

    :label {:value ""}

    :padding {:value "16px"}

    :margin {:value "24px"}

    :boxShadow {:value "0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12), 0 3px 1px -2px rgba(0, 0, 0, 0.2)"}

    :fname {:value "WORLD"
                ;; :type String
                :observer #(.log js/console (str "Addressee CHG OBSERVED " %))
                }
    }

   ;; observers: [
   ;;   '_render(size, label, padding, margin, boxShadow)'
   ;; ],

   ;; :render (fn [:size :label :padding :margin :boxShadow]
   ;;           (this-as this (del/render this size label padding margin boxShadow)))

   :foo (fn [:size :label] (println "FOO OBS"))

   :bar {:x (this-as this (set! (.. this -size) 34)  (set! (.. this -label) "x"))}

   :created (fn [] (println "CREATED"))

   ;; :ready (fn [] (this-as this (println "READY 2")))
   }

  ;; poly/Lifecycle
  ;; (created [] (println "CREATED"))
  ;; (ready [] (this-as this (println "READY")
  ;;                    (set! (.. this -style -display) "block")))


  (:codom
   (h/h1 {:$hover {:background-color "red"}} "HELLO" :fname))

  miraj.html.protocol/Mouse
  (mouseover [x] (.log js/console "MOUSEOVER"))

)

