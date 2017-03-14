(ns miraj.polymer.layout.demos.sample-content.delegate)

(enable-console-print!)

(println "LOADING miraj.layout.demos.sample-content.delegate")

;; (defn created [] (println "CREATED"))

;; (def lorem-ipsum-strings [
;;         "Lorem ipsum dolor sit amet, per in nusquam nominavi periculis, sit elit oportere ea.",
;;         "Ut labores minimum atomorum pro. Laudem tibique ut has.",
;;         "Fugit adolescens vis et, ei graeci forensibus sed.",
;;         "Convenire definiebas scriptorem eu cum. Sit dolor dicunt consectetuer no.",
;;         "Ea duis bonorum nec, falli paulo aliquid ei eum.",
;;         "Usu eu novum principes, vel quodsi aliquip ea.",
;;         "Has at minim mucius aliquam, est id tempor laoreet.",
;;         "Pro saepe pertinax ei, ad pri animal labores suscipiantur.",
;;         "Detracto suavitate repudiandae no eum. Id adhuc minim soluta nam.",
;;         "Iisque perfecto dissentiet cum et, sit ut quot mandamus, ut vim tibique splendide instructior.",
;;         "Id nam odio natum malorum, tibique copiosae expetenda mel ea.",
;;         "Cu mei vide viris gloriatur, at populo eripuit sit.",
;;         "Modus commodo minimum eum te, vero utinam assueverit per eu.",
;;         "No nam ipsum lorem aliquip, accumsan quaerendum ei usu."
;;       ])

;; (defn random-string [size]
;;   (let [ct (count lorem-ipsum-strings)
;;         s (for [n (range size)]
;;             (let [idx (Math/floor
;;                        (* (Math/random) ct))]
;;               (nth lorem-ipsum-strings idx)))]
;;     (str s)))

;; (def mychars
;;   (map char (concat (range 48 58) (range 66 92) (range 97 123))))

;; (defn random-char []
;;   (nth mychars (rand-int (count mychars))))

;; (defn render [this size label padding margin boxShadow]
;;   (repeat size
;;           (let [html-str (str
;;                       "<div style=\"box-shadow: ' + boxShadow +  '; padding: ' + padding + '; margin: ' + margin + '; border-radius: 5px; background-color: #fff; color: #757575;\">"
;;                       "<div style=\"display: inline-block; height: 64px; width: 64px; border-radius: 50%; background: #ddd; line-height: 64px; font-size: 30px; color: #555; text-align: center;\">"
;;                       (random-char)
;;                       "</div>"
;;                       "<div style=\"font-size: 22px; margin: 16px 0; color: #212121;\">"
;;                       (.-label this) " " (random-string 1)
;;                       "</div>"
;;                       "<p style=\"font-size: 16px;\">"
;;                       (random-string 1) "</p>"
;;                       "<p style=\"font-size: 14px;\">"
;;                       (random-string 3) "</p>"
;;                       "</div>")]
;;             (set! (.-innerHTML this) html-str))))


(println "LOADED miraj.layout.demos.sample-content.delegate")
