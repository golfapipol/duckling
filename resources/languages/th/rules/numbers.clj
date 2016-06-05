(
  "text integer (0..9)"
  #"(?i)(ไม่มี|ศูนย์|ว่าง|หนึ่ง|เอ็ด|สอง|สาม|สี่|ห้า|หก|เจ็ด|แปด|เก้า)"
  {
    :dim :number
    :integer true
    :value (get {"ไม่มี" 0 "ศูนย์" 0 "ว่าง" 0 "หนึ่ง" 1 "เอ็ด" 1 "สอง" 2 "สาม" 3 "สี่" 4 "ห้า" 5 "หก" 6 "เจ็ด" 7 "แปด" 8 "เก้า" 9}
      (-> %1 :groups first)
    )
  }

  "text integer (10..90)"
  #"(?i)(สิบ|ยี่สิบ|สามสิบ|สี่สิบ|ห้าสิบ|หกสิบ|เจ็ดสิบ|แปดสิบ|เก้าสิบ)"
  {
    :dim :number
    :integer true
    :value (get {"สิบ" 10 "ยี่สิบ" 20 "สามสิบ" 30 "สี่สิบ" 40 "ห้าสิบ" 50 "หกสิบ" 60 "เจ็ดสิบ" 70 "แปดสิบ" 80 "เก้าสิบ" 90}
      (-> %1 :groups first)
    )
  }

  "text integer 20"
  #"(?i)(ยี่สิบ)"
  {
    :dim :number
    :integer true
    :value 20
    :grain 1
  }

  "text integer 100"
  #"(?i)(ร้อย)"
  {
    :dim :number
    :integer true
    :value 100
  }

  "text integer (100..900)"
  [(integer 1 9) (integer 100)]
  {
    :dim :number
    :integer true
    :value (* (:value %1) (:value %2))
  }

  ; "text integer 1000"
  ; #"(?i)(พัน)"
  ; {
  ;   :dim :number
  ;   :integer true
  ;   :value 1000
  ; }
  ;
  ; "text integer (1000..9000)"
  ; [(integer 1 9) (integer 1000)]
  ; {
  ;   :dim :number
  ;   :integer true
  ;   :value (* (:value %1) (:value %2))
  ; }


  "text integer (11..99)"
  [(integer 10 90) (integer 1 9)]
  {
    :dim :number
    :integer true
    :value (+ (:value %1) (:value %2))
  }

  "text integer 101..999"
  [(integer 100 900) (integer 1 99)]
  {
    :dim :number
    :integer true
    :value (+ (:value %1) (:value %2))
    :grain 1
  }

)
