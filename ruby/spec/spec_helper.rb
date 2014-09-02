require 'json'
require 'pp'

def init (file)
  name = File.basename(file, "_spec.rb")
  require_relative "../app/%s" % [name]

  path = file.sub(/\.rb$/, ".json")
  json = JSON.parse(File.read(path))

  [name, json]
end

def test (name, data, opts={})
  args     = data[0...-1]
  expected = data[-1]
  results  = Object.const_get(name).solution(*args)

  if opts.has_key? :float
    if expected == 0
      expect(results).to eq(0)
    else
      p = (results - expected).abs / expected
      expect(p).to be < 0.01
    end
  else
    expect(results).to eq(expected)
  end
end
