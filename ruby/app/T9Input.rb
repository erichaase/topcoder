# T9Input[http://community.topcoder.com/stat?c=problem_statement&pm=1966]

class T9Input
  def self.solution (messages)
    init(messages)
    out = []
    messages.each do |message|
      out << translate_message(message)
    end
    out
  end

  def self.init (messages)
    @@h = {}
    ('a'..'z').to_a.push(' ').each do |c|
      case c
      when /a|b|c/
        @@h[c] = "2"
      when /d|e|f/
        @@h[c] = "3"
      when /g|h|i/
        @@h[c] = "4"
      when /j|k|l/
        @@h[c] = "5"
      when /m|n|o/
        @@h[c] = "6"
      when /p|q|r|s/
        @@h[c] = "7"
      when /t|u|v/
        @@h[c] = "8"
      when /w|x|y|z/
        @@h[c] = "9"
      when / /
        @@h[c] = "#"
      end
    end

    @@d = {}
    messages.each do |message|
      message.split.each do |word|
        word_t9 = ""
        word.each_char do |char|
          word_t9 += @@h[char]
        end

        if @@d.has_key? (word_t9)
          words = @@d[word_t9]
          words.push(word).sort! if not words.include? (word)
        else
          @@d[word_t9] = [word]
        end
      end
    end
  end

  def self.translate_message (message)
    message_t3 = ""
    word       = ""

    message.each_char do |char|
      if char == " "
        message_t3 << translate_word(word)
        word = ""
        message_t3 << @@h[char]
      else
        word += char
      end
    end
    message_t3 << translate_word(word)

    message_t3
  end

  def self.translate_word (word)
    return "" if word.empty?

    word_t9 = ""
    word.each_char do |char|
      word_t9 += @@h[char]
    end

    i = @@d[word_t9].find_index(word)
    word_t9 += "0" * i
  end
end
