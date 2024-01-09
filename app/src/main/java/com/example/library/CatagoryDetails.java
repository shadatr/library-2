package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CatagoryDetails extends AppCompatActivity {

    String[][] romanceBooks = {
            {"Pride and Prejudice", "Description: Set in the early 19th century, this timeless classic follows the spirited Elizabeth Bennet as she navigates love, societal expectations, and personal growth. The novel explores themes of class, prejudice, and the transformative power of love.", "Price: $14.99"},
            {"The Notebook", "Description: A poignant tale of Noah and Allie, two young lovers separated by social class and circumstance. The Notebook weaves together themes of passion, commitment, and enduring love, capturing the hearts of readers with its emotional depth.", "Price: $12.99"},
            {"Me Before You", "Description: This emotional rollercoaster revolves around the relationship between Louisa Clark and Will Traynor. Touching on themes of life, choices, and disability, it's a powerful exploration of love's ability to transcend boundaries.", "Price: $16.99"},
            {"Outlander", "Description: A captivating blend of historical fiction, romance, and time travel, Outlander follows Claire Randall as she navigates 18th-century Scotland. The novel is rich in detail, exploring love amid political intrigue and cultural differences.", "Price: $18.99"},
            {"Eleanor Oliphant Is Completely Fine", "Description: Eleanor Oliphant is an eccentric and socially awkward character whose life takes an unexpected turn when she develops feelings for a musician. The novel is a heartwarming journey of self-discovery and human connection.", "Price: $15.99"},
            {"The Fault in Our Stars", "Description: Hazel Grace Lancaster and Augustus Waters, two teenagers grappling with cancer, find love and hope in each other. John Green's poignant exploration of life, death, and love has resonated with readers of all ages.", "Price: $13.99"},
            {"A Walk to Remember", "Description: Landon and Jamie's unlikely love story unfolds against the backdrop of a small town. Nicholas Sparks crafts a tale of redemption, faith, and the enduring power of love in the face of life's challenges.", "Price: $14.99"},
            {"The Hating Game", "Description: This workplace romantic comedy follows Lucy Hutton and Joshua Templeman, who share a competitive and witty dynamic. As their professional rivalry turns into something more, The Hating Game delivers humor, banter, and a satisfying love story.", "Price: $11.99"}
    };
    // Fiction category
    String[][] fictionBooks = {
            {"To Kill a Mockingbird", "Description: Set in the racially charged American South, the novel explores themes of morality and injustice through the eyes of Scout Finch, a young girl witnessing her father's defense of an innocent black man accused of rape.", "Price: $14.99"},
            {"The Great Gatsby", "Description: A tale of love, decadence, and the American Dream during the Roaring Twenties. Jay Gatsby's pursuit of wealth to win back his lost love is a poignant commentary on the illusions of success.", "Price: $12.99"},
            {"One Hundred Years of Solitude", "Description: A magical realist masterpiece that chronicles the multi-generational Buendía family in the fictional town of Macondo. The novel explores the cyclical nature of history and the impact of colonialism.", "Price: $16.99"},
            {"The Kite Runner", "Description: A powerful exploration of friendship, betrayal, and redemption set against the backdrop of Afghanistan's tumultuous history. Amir's journey to confront his past is both heartbreaking and inspiring.", "Price: $13.99"},
            {"Beloved", "Description: This Pulitzer Prize-winning novel delves into the haunting legacy of slavery. Sethe, an escaped slave, is haunted by the ghost of her dead daughter and must confront the trauma of her past.", "Price: $15.99"},
            {"The Catcher in the Rye", "Description: Narrated by the iconic Holden Caulfield, the novel explores teenage angst, identity, and the search for authenticity. A timeless coming-of-age story that resonates with readers of all ages.", "Price: $11.99"},
            {"Life of Pi", "Description: After a shipwreck, Pi Patel is left stranded on a lifeboat in the Pacific Ocean with a Bengal tiger named Richard Parker. The novel explores themes of survival, faith, and the power of storytelling.", "Price: $14.99"},
            {"The Handmaid's Tale", "Description: Set in a dystopian future, the novel explores a society where women's rights are severely restricted. Offred, a Handmaid, narrates her struggle for autonomy in a repressive regime.", "Price: $12.99"}
    };

    // Science Fiction category
    String[][] scienceFictionBooks = {
            {"Dune", "Description: Set in a distant future, 'Dune' follows the journey of Paul Atreides as he navigates political intrigue and ecological challenges on the desert planet Arrakis. A masterpiece of world-building and political drama.", "Price: $17.99"},
            {"Neuromancer", "Description: A groundbreaking cyberpunk novel that explores the virtual world of cyberspace. Case, a washed-up computer hacker, is hired for a final job that blurs the lines between reality and technology.", "Price: $13.99"},
            {"Ender's Game", "Description: In a future where gifted children are trained for war, Ender Wiggin emerges as a brilliant strategist. The novel explores themes of leadership, empathy, and the consequences of warfare.", "Price: $12.99"},
            {"The Hunger Games", "Description: In a dystopian society, Katniss Everdeen becomes a symbol of rebellion after participating in the brutal Hunger Games. The trilogy explores themes of survival, sacrifice, and resistance.", "Price: $14.99"},
            {"Snow Crash", "Description: A fast-paced cyberpunk adventure that combines virtual reality, linguistics, and corporate espionage. Hiro Protagonist navigates a high-tech world to unravel a conspiracy threatening society.", "Price: $15.99"},
            {"Brave New World", "Description: In a dystopian future, society is controlled through technology, conditioning, and the suppression of individuality. The novel explores the consequences of a society driven by pleasure and conformity.", "Price: $11.99"},
            {"The Left Hand of Darkness", "Description: Set on the planet Gethen, where inhabitants can change gender at will, the novel explores themes of gender, politics, and friendship. Genly Ai, a human envoy, navigates a complex cultural landscape.", "Price: $16.99"},
            {"Foundation", "Description: The first book in the Foundation series, it follows mathematician Hari Seldon's efforts to preserve knowledge and shorten a dark age in the Galactic Empire's future. A classic exploration of psychohistory and the rise and fall of civilizations.", "Price: $14.99"}
    };

    String[][] biographyMemoirBooks = {
            {"Steve Jobs",
                    "Isaacson's authorized biography provides a comprehensive look at the life of Steve Jobs, co-founder of Apple Inc., capturing his genius, innovation, and complex personality.",
                    "Price: $19.99"},
            {"The Diary of a Young Girl",
                    "Anne Frank's diary, written while she and her family hid from the Nazis during World War II, provides a poignant and intimate account of life in hiding.",
                    "Price: $11.99"},
            {"Unbroken: A World War II Story of Survival, Resilience, and Redemption",
                    "The true story of Louis Zamperini, an Olympic athlete turned World War II bombardier who survives a plane crash only to face extraordinary challenges as a prisoner of war.",
                    "Price: $16.99"},
            {"The Glass Castle",
                    "Walls recounts her unconventional and often challenging childhood with her eccentric parents, providing a moving and thought-provoking memoir.",
                    "Price: $13.99"},
            {"Born a Crime: Stories from a South African Childhood",
                    "Comedian Trevor Noah shares his experiences growing up in apartheid-era South Africa, blending humor with insights into racism, identity, and resilience.",
                    "Price: $14.99"},
            {"Hillbilly Elegy: A Memoir of a Family and Culture in Crisis",
                    "Vance reflects on his upbringing in Appalachia and explores the challenges faced by working-class families in America, offering a personal and sociopolitical perspective.",
                    "Price: $12.99"},
            {"The Wright Brothers",
                    "McCullough's biography chronicles the lives of Orville and Wilbur Wright, pioneers of aviation who achieved the first successful powered flight.",
                    "Price: $18.99"},
            {"Wild: From Lost to Found on the Pacific Crest Trail",
                    "Strayed recounts her transformative journey of self-discovery and healing as she hikes over a thousand miles on the Pacific Crest Trail after a series of personal hardships.",
                    "Price: $15.99"}
    };

    // Historical Fiction category
    String[][] historicalFictionBooks = {
            {"All the Light We Cannot See",
                    "Set during World War II, the novel follows the lives of a blind French girl and a German boy whose paths eventually cross. A beautifully written exploration of humanity in the face of war.",
                    "Price: $15.99"},
            {"The Book Thief",
                    "Narrated by Death, the novel follows Liesel Meminger, a young girl in Nazi Germany, as she steals books and shares them with her neighbors and the Jewish man hiding in her basement.",
                    "Price: $13.99"},
            {"Wolf Hall",
                    "This historical novel chronicles the rise of Thomas Cromwell, a key figure in the court of King Henry VIII. The book provides a fresh perspective on Tudor England and political intrigue.",
                    "Price: $17.99"},
            {"The Nightingale",
                    "Set in France during World War II, the novel follows two sisters as they navigate love, loss, and resistance against the backdrop of German-occupied France. A moving portrayal of courage and sacrifice.",
                    "Price: $14.99"},
            {"The Pillars of the Earth",
                    "A historical epic set in 12th-century England, the novel spans decades and follows the lives of various characters linked by the construction of a cathedral. Themes of power, love, and ambition are central to the narrative.",
                    "Price: $16.99"},
            {"Atonement",
                    "A story of love, betrayal, and the consequences of a young girl's mistake. Set before and during World War II, the novel explores...",
                    "Price: $11.99"},
            // Add more books in the historical fiction category as needed
    };

    String[][] fantasyBooks = {
            {"The Hobbit",
                    "Bilbo Baggins, a hobbit, embarks on a grand adventure to reclaim treasure guarded by the dragon Smaug. This classic fantasy novel introduces readers to the rich world of Middle-earth.",
                    "Price: $14.99"},
            {"Harry Potter and the Sorcerer's Stone",
                    "The first book in the beloved series follows young Harry Potter as he discovers his magical heritage and begins his education at Hogwarts School of Witchcraft and Wizardry.",
                    "Price: $12.99"},
            {"A Song of Ice and Fire: A Game of Thrones",
                    "The first book in the epic fantasy series 'A Song of Ice and Fire' introduces readers to the complex and treacherous political landscape of the Seven Kingdoms.",
                    "Price: $18.99"},
            {"The Name of the Wind",
                    "The first book in 'The Kingkiller Chronicle' follows Kvothe, a gifted young musician and magician, as he recounts his life's story, including the events that led to him becoming a legendary figure.",
                    "Price: $16.99"},
            {"Mistborn: The Final Empire",
                    "In a world ruled by the immortal Lord Ruler, a young street thief named Vin discovers her magical abilities and joins a group planning to overthrow the oppressive regime.",
                    "Price: $14.99"},
            {"The Chronicles of Narnia: The Lion, the Witch and the Wardrobe",
                    "Four siblings discover the magical land of Narnia, where they join forces with Aslan the lion to defeat the White Witch. A timeless tale of adventure, courage, and the battle between good and evil.",
                    "Price: $11.99"},
            {"American Gods",
                    "Shadow Moon, an ex-convict, becomes embroiled in a conflict between old and new gods. Neil Gaiman's novel explores mythology, belief, and the changing nature of worship in modern times.",
                    "Price: $15.99"},
            {"The Lies of Locke Lamora",
                    "Set in the city of Camorr, this fantasy novel follows a group of skilled con artists led by the charismatic Locke Lamora as they navigate a world of crime and intrigue.",
                    "Price: $13.99"}
    };

    TextView tv;
    ImageView back;
    String[][] catagory_details={};
    ArrayList List;
    HashMap<String,String> item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory_details);
        tv= findViewById(R.id.title);
        back= findViewById(R.id.back);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Romance")==0){
            catagory_details=romanceBooks;
        }else if(title.compareTo("Fantacy")==0){
            catagory_details=fantasyBooks;
        }else if(title.compareTo("Biography/Memoir")==0){
            catagory_details=biographyMemoirBooks;
        }else if(title.compareTo("Fiction")==0){
            catagory_details=fictionBooks;
        }else if(title.compareTo("History")==0){
            catagory_details=historicalFictionBooks;
        }else if(title.compareTo("Science Fiction")==0){
            catagory_details=scienceFictionBooks;
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CatagoryDetails.this,findBook.class));
            }
        });

        List = new ArrayList();
        for (int i=0;i<catagory_details.length;i++){
            item= new HashMap<String,String>();
            item.put("line1",catagory_details[i][0]);
            item.put("line2",catagory_details[i][1]);
            item.put("line3",catagory_details[i][2]);
            List.add(item);
        }
        sa=new SimpleAdapter(this,List,R.layout.multi_lines, new String[]{"line1","line2","line3"}, new int[]{R.id.line1,R.id.line2,R.id.line3});
        ListView lst= findViewById(R.id.list);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it =new Intent(CatagoryDetails.this,BookDetailsActivity.class);
                it.putExtra("text1",catagory_details[i][0]);
                it.putExtra("text2",catagory_details[i][1]);
                it.putExtra("text3",catagory_details[i][2]);
                startActivity(it);
            }
        });

    }

}