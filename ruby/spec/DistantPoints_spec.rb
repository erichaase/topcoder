name = File.basename(__FILE__, "_spec.rb")
require_relative "../app/%s" % [name]

path = __FILE__.sub(/\.rb$/, ".json")
$DATA = JSON.parse(File.read(path))

describe name do
  after(:each) do
    results = Object.const_get(name).getKth(@n, @k)
    expect(results).to eq(@expected)
  end

  $DATA.each_with_index do |t, i|
    it "test #{i}" do
      @n        = t[0]
      @k        = t[1]
      @expected = t[2]
    end
  end
end
